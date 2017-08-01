package connect.reservation.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import connect.reservation.dao.CommentDao;
import connect.reservation.domain.Product;
import connect.reservation.domain.ReservationUserComment;
import connect.reservation.dto.ReservationComment;
import connect.reservation.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<ReservationComment> getList(int productId, int start, int end) {		
		List<ReservationComment> list = new ArrayList<ReservationComment>();
		
		list = getNickname(commentDao.getCommentList(productId, start, end));

		return list;
	}
	
	@Override
	public int getCount(int productId){
		return commentDao.getScoreList(productId).size();
	}
	
	@Override
	public double getScoreAverage(int productId) {
		List<ReservationComment> scoreList = new ArrayList<ReservationComment>();
		scoreList = commentDao.getScoreList(productId);
		
		double scoreAverage = 0;

		for (int i = 0; i < scoreList.size(); i++)
			scoreAverage += scoreList.get(i).getScore();
		scoreAverage = Double.parseDouble(String.format("%.1f", scoreAverage / scoreList.size()));
		
		return scoreAverage;
	}
	
	@Override
	public List<ReservationComment> getImage(int commentId) {
		return commentDao.getImageList(commentId);
	}
	
	@Override
	public Product getName(int reservationId) {
		return commentDao.getReservationName(reservationId);
	}
	
	@Override
	@Transactional(readOnly = false)
	public int add(ReservationUserComment reservationUserComment) {
		reservationUserComment.setCreateDate(getDate());
				
		return commentDao.add(reservationUserComment);
	}
	
	public Timestamp getDate(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return java.sql.Timestamp.valueOf(sdf.format(timestamp));
	}
	
	public List<ReservationComment> getNickname(List<ReservationComment> list) {
		String nickname = "";
		
		for(int i=0; i<list.size(); i++) {
			nickname = list.get(i).getNickname();
			if(nickname.length() > 4){
				nickname = nickname.substring(0, nickname.length()-4);
			}
			else {
				nickname = "";
			}
			nickname += "****";
			list.get(i).setNickname(nickname);
		}
		
		return list;
	}
}
