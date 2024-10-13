package servlet;

import entity.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OngoingMatchesService;

import java.io.IOException;


@MultipartConfig
public class NewMatchServlet extends HttpServlet {
    private OngoingMatchesService ongoingMatchesService;

    @Override
    public void init() throws ServletException {
        this.ongoingMatchesService = new OngoingMatchesService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/views/newMatch.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player_1 = req.getParameter("player1");
        String player_2 = req.getParameter("player2");

        if (player_1.equals(player_2)){
            resp.sendError(401,"ДОлбаеб имена одинаковые");
            return;
        }

        var uuid = ongoingMatchesService.createNewMath(player_1,player_2).getUuid();

       resp.sendRedirect(String.format("/match-score?uuid=%s", uuid.toString()));
    }

}
