package com.jsp.web.controller.board;

import com.jsp.biz.board.BoardDAO;
import com.jsp.biz.board.BoardVO;
import com.jsp.biz.user.UserVO;
import com.jsp.web.controller.Controller;
import com.jsp.web.service.board.WriteBoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WriteBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        BoardVO vo = getWriteBoardVO(request);
        WriteBoardService.getInstance().run(vo);
        return "getBoardList.do";
    }

    private static BoardVO getWriteBoardVO(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setUserId(user.getId());
        boardVO.setText(text);
        boardVO.setRole(user.getRole());
        boardVO.setViewCnt(0L);
        return boardVO;
    }
}
