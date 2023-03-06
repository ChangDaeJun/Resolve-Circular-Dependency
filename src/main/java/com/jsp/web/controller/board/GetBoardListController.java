package com.jsp.web.controller.board;

import com.jsp.domain.board.BoardDAO;
import com.jsp.domain.board.BoardVO;
import com.jsp.domain.user.UserDAO;
import com.jsp.domain.user.UserVO;
import com.jsp.web.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
            BoardDAO boardDAO = new BoardDAO();
            List<BoardVO> boardVOList = boardDAO.getList();

            for(BoardVO board : boardVOList){
                UserVO userVO = new UserVO();
                userVO.setId(board.getUserId());

                UserDAO userDAO = new UserDAO();
                UserVO createUser = userDAO.findById(userVO);

                board.setUserName(createUser.getName());
            }

            request.setAttribute("boardList", boardVOList);

            return "GetBoardList";
    }
}
