package innerclass;

public class Outer {
    private String inst = "인스턴스";
    private static String sttc = "클래스";

    //    1. 멤버 인스턴스 클래스
    class InnerInstMember {
        //  ⭐️ 외부 클래스의 필드와 클래스 접근 가능
        private String name = inst + " 필드로서의 클래스";
        private InnerSttcMember innerSttcMember = new InnerSttcMember();

        public void func () {
            System.out.println(name);
            System.out.println( sttc);
        }
    }

    //     2. 정적(클래스) 내부 클래스 
    public static class InnerSttcMember {
        //  ⭐️ 외부 클래스의 클래스 필드만 접근 가능
        private String name = sttc + " 필드로서의 클래스";

        //  ⚠️ static이 아닌 멤버 인스턴스 클래스에도 접근 불가!
        //  private InnerInstMember innerInstMember = new InnerInstMember();

        public void func () {
            // ⚠️ 인스턴스 메소드지만 클래스가 정적(클래스의)이므로 인스턴스 필드 접근 불가
            //  name += inst;
            System.out.println(name);
        }
    }

    public void memberFunc () {
        //   메소드 안에 정의된 클래스 ( 지역 내부 클래스) 
        //   스코프가 메소드 내로 제한됨
        class MethodMember {
            //  외부의 필드와 클래스에 접근은 가능
            String instSttc = inst + " " + sttc;
            InnerInstMember innerInstMember = new InnerInstMember();
            InnerSttcMember innerSttcMember = new InnerSttcMember();

            public void func () {
                innerInstMember.func();
                innerSttcMember.func();
                System.out.println(" 지역내부클래스의 매소드 실행  !!");
               
            }
        }

        new MethodMember().func();
    }

    public void innerFuncs () {
        new InnerInstMember().func();
        new InnerSttcMember().func();
    }

    public InnerInstMember getInnerInstMember () {
        return new InnerInstMember();
    }
}