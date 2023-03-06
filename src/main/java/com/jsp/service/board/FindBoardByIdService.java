package com.jsp.service.board;


import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;
import com.jsp.domain.user.UserVO;
import com.jsp.service.user.FindUserByIdService;

public class FindBoardByIdService {
    private FindBoardByIdService(){}
    private static class FindBoardByIdServiceHelper{
        private static final FindBoardByIdService INSTANCE = new FindBoardByIdService();
    }
    public static FindBoardByIdService getInstance(){
        return FindBoardByIdService.FindBoardByIdServiceHelper.INSTANCE;
    }

    public BoardVO run(Long id){
        BoardVO boardVO = new BoardVO();
        boardVO.setId(id);
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.findById(boardVO);

        //글 작성자 조회
        UserVO createUser = FindUserByIdService.getInstance().run(board.getUserId());
        board.setUserName(createUser.getName());
        return board;
    }
}
