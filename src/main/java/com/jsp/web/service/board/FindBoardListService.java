package com.jsp.web.service.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.user.UserDAO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.service.user.FindUserByIdService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class FindBoardListService {
    private FindBoardListService(){}
    private static class FindBoardListServiceHelper{
        private static final FindBoardListService INSTANCE = new FindBoardListService();
    }
    public static FindBoardListService getInstance(){
        return FindBoardListService.FindBoardListServiceHelper.INSTANCE;
    }

    public List<BoardVO> run() {
            BoardDAO boardDAO = new BoardDAO();
            List<BoardVO> boardList = boardDAO.getList();

            for(BoardVO board : boardList){
                UserVO createUser = FindUserByIdService.getInstance().run(board.getUserId());
                board.setUserName(createUser.getName());
            }

            return boardList;
    }
}
