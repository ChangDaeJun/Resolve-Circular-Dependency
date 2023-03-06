package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.service.board.UpdateBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        BoardVO vo = getUpdateBoardVO(request);
        UpdateBoardService.getInstance().run(vo);
        return "getBoardList.do";
    }

    private static BoardVO getUpdateBoardVO(HttpServletRequest request) {
        BoardVO boardVO = new BoardVO();
        boardVO.setId(Long.parseLong(request.getParameter("id")));
        boardVO.setText(request.getParameter("text"));
        boardVO.setTitle(request.getParameter("title"));
        return boardVO;
    }
}
