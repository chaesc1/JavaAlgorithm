package SWexpertAcademy.D2;
//달팽이 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class P1954 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int input = Integer.parseInt(br.readLine());
            int[][] map = new int[input][input];
            int count = 1;
            //시작좌표
            int x=0;
            int y=0;
            int d = 0;

            while (count <= input * input){
                map[x][y] = count++;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= input || ny < 0 || ny >= input || map[nx][ny] != 0){
                    d = (d+1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }
            System.out.println("#"+(i+1));
            for (int j = 0; j < input; j++) {
                for (int k = 0; k < input; k++) {
                    System.out.print(map[j][k]+" ");
                }
                System.out.println();
            }
        }
    }
}
