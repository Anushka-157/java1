public class Ma{
    public static void main(String[] args){
        if(args.length!=1)
        {
            System.out.println("usage");
            return;
        }
        int N=Integer.parseInt(args[0]);
        int[][] matrixA=new int[N][N];
        int[][] matrixB=new int[N][N];
        int[][] resultMatrix=new int[N][N];
        fillMatrix(matrixA,N);
        fillMatrix(matrixB,N);
        for(int i=0;i<=N;i++){
            for(int j=0;i<=N;i++){
                resultMatrix[i][j]=matrixA[i][j]+matrixB[i][j];
            }
        }
    System.out.println("Matrix A:");
    printMatrix(matrixA,N);
    System.out.println("Matrix B:");
    printMatrix(matrixB,N);
    System.out.println("Sum:");
    printMatrix(resultMatrix,N);
    }
    private static void fillMatrix(int[][] matrix,N){
        for(int i=0;i<=N;i++){
            for(int j=0;i<=N;i++){
                matrix[i][j]=(int)(Math.random()*100);
            }
        }
    }
    private static void fillMatrix(int[][] matrix,N){
        for(int i=0;i<=N;i++){
            for(int j=0;i<=N;i++){
                System.out.printmatrix[i][j]+"");
            }
            System.out.println();
           }
        }