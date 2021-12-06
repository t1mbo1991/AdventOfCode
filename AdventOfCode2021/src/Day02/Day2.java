package Day02;

public class Day2 {
    public static void main(String[] args) {
        int depth = 0;
        int pos = 0;
        int aim = 0;
        for(int i=0; i< args.length;i+=2) {
            if(args[i].equals("forward")) {
                pos+=Integer.parseInt(args[i+1]);
                depth+=aim*Integer.parseInt(args[i+1]);
            }
            if(args[i].equals("down")) aim+=Integer.parseInt(args[i+1]);
            if(args[i].equals("up")) aim-=Integer.parseInt(args[i+1]);
        }
        System.out.println("Depth*Pos= "+ depth*pos);
    }
}
