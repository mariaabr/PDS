package lab03;

public class Jogo implements JGaloInterface {

    char player = 'X';
    char winner = ' ';

    char[][] map = new char[4][4];

    @Override
    public char getActualPlayer() {

            return player;
    }

    @Override
    public boolean setJogada(int lin, int col) {
            map[lin][col] = getActualPlayer();
            if (player == 'X'){
                player = 'O';
            }
            else{
                player = 'X';
            }
            return true;        
    }

    @Override
    public boolean isFinished() {

        for(int i=0; i<3;i++ ){
            for(int j=0;j<3;j++){
                if(map[i][1]==map[i][2] && map[i][2]==map[i][3] && map[i][1]!= 0 ){
                    winner = map[i][1];
                    return true;
                }
                if(map[1][j]==map[2][j] && map[2][j]==map[3][j] && map[1][j]!= 0){
                    winner = map[1][j];
                    return true;
                }
                if(map[1][1]==map[2][2] && map[2][2]==map[3][3] && map[1][1]!= 0){
                    winner = map[1][1];
                    return true;
                }
                if(map[1][3]==map[2][2] && map[2][2]==map[3][1] && map[1][3]!= 0){
                    winner = map[1][3];
                    return true;
                }
            }
        }
        boolean completo = true;
        for(int i=1; i<4;i++ ){
            for(int j=1;j<4;j++){
                if(map[i][j]== 0){
                    completo = false;
                }
            }
        }
        if(completo== false){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public char checkResult() {
        if (winner == ' '){
            return ' ';
        }
        else{
            return winner;
        }
    }
    
}
