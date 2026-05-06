import java.util.*;
import java.io.*;

public class Main {

    static int K, M;
    static int[][] maps;
    static Queue<Integer> wall;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    //격자 전체에서 점수와 제거할 좌표들 모두 반환
    static class EvalResult {
