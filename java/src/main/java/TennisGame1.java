
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    @Override
    public String getScore() {
        String scoreString = "";
        int tmp=0;  // Temporary score
        if (m_score1==m_score2)
        {
            switch (m_score1)
            {
                case 0:
                        scoreString = "Love-All";
                    break;
                case 1:
                        scoreString = "Fifteen-All";
                    break;
                case 2:
                        scoreString = "Thirty-All";
                    break;
                default:
                        scoreString = "Deuce";
                    break;
                
            }
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minRes = m_score1-m_score2;
            if (minRes==1) scoreString ="Advantage player1";
            else if (minRes ==-1) scoreString ="Advantage player2";
            else if (minRes>=2) scoreString = "Win for player1";
            else scoreString ="Win for player2";
        }
        else
        {
            for (int a=1; a<3; a++)
            {
                if (a==1) tmp = m_score1;
                else { scoreString+="-"; tmp = m_score2;}
                switch(tmp)
                {
                    case 0:
                        scoreString+="Love";
                        break;
                    case 1:
                        scoreString+="Fifteen";
                        break;
                    case 2:
                        scoreString+="Thirty";
                        break;
                    case 3:
                        scoreString+="Forty";
                        break;
                }
            }
        }
        return scoreString;
    }
}
