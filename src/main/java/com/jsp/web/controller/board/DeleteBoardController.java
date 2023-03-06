package com.jsp.web.controller.board;

import com.jsp.domain.board.BoardVO;
import com.jsp.web.controller.Controller;
import com.jsp.service.board.DeleteBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        BoardVO vo = getDeleteBoardVO(request);
        DeleteBoardService.getInstance().run(vo);
        return "getBoardList.do";
    }

    private static BoardVO getDeleteBoardVO(HttpServletRequest request) {
        String id = request.getParameter("id");
        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.parseLong(id));
        return boardVO;
    }
}
