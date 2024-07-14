import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TicTacToe{
    int[][] board;
    boolean flip;
    int i, j;
    boolean result;
    boolean canDo[][];
    JFrame f;
    JFrame win;
    JLabel lab;
    int freeCells;
    JButton[][] boardGUI;
    TicTacToe(){
        f=new JFrame("TicTacToe");
        win = new JFrame("Yayyyy!!!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flip = true;
        canDo = new boolean[3][3];
        freeCells = 9;
        result = true;



        board = new int [3][3];
        boardGUI = new JButton[3][3];

        for(i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                boardGUI[i][j] = new JButton();
                boardGUI[i][j].setBounds(i*70, j*70, 70, 70);
                board[i][j] = -1;
                canDo[i][j] = true;
                final int u = i, v = j;
                boardGUI[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        
                        if(canDo[u][v] && result){
                            if(flip) {
                                boardGUI[u][v].setText("X");
                                board[u][v] = 1;
                            }
                            else {
                                boardGUI[u][v].setText("O");
                                board[u][v] = 0;
                            }
                            TicTacToe.this.boolFlip();
                            TicTacToe.this.canDo[u][v] = false;
                            freeCells--;
                        }
                        if(check()){
                            lab = new JLabel("                     "+boardGUI[u][v].getText() + " wins!!");
                            f.setVisible(false);
                            win.setVisible(true);
                            win.setSize(200, 100);
                            win.add(lab);
                            // for(int q = 0; q < 3; q++){
                            //     for(int p = 0; p < 3; p++){
                            //         boardGUI[q][p].setText(boardGUI[u][v].getText());
                            //     }
                            // }
                            result = false;
                        }
                        else if(freeCells == 0){
                            f.setVisible(false);
                            win.setTitle("Draw!!");
                            lab = new JLabel("                     Draw!!!");
                            win.setVisible(true);
                            win.setSize(200, 100);
                            win.add(lab);
                            result = false;
                        }
                    }
                });
            }
        }
        for(i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                f.add(boardGUI[i][j]);
            }
        }
        f.setSize(224, 247);
        f.setLayout(null);
        f.setVisible(true);
    }
    void boolFlip(){
        flip = !flip;
    }
    boolean check(){
        for(int u = 0; u < 3; u++){
            if(board[u][0] == board[u][1] && board[u][2] == board[u][1] && board[u][1] != -1) return true;
        }

        for(int u = 0; u < 3; u++){
            if(board[0][u] == board[1][u] && board[2][u] == board[1][u] && board[1][u] != -1) return true;
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1]!=-1) return true;
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1]!=-1) return true;

        return false;
    }
    public static void main(String[] args) {
        TicTacToe x =new TicTacToe();
    }

}