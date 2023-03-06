package com.jsp.service.board;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;
import com.jsp.domain.user.UserVO;
import com.jsp.service.user.FindUserByIdService;

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
