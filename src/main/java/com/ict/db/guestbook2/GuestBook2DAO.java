package com.ict.db.guestbook2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestBook2DAO {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss==null) {
			ss=GuestBook2DBService.getFactory().openSession();
		}
		return ss;
	}
	
	// 리스트
	public static List<GuestBook2VO> getList() {
		try {
			List<GuestBook2VO> list = null;
			// 파라미터값 없음
			list = getSession().selectList("guestbook2.list");
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 상세보기
	public static GuestBook2VO getOneList(String idx) {
		try {
			GuestBook2VO g2vo = null;
			g2vo = getSession().selectOne("guestbook2.detail", idx);
			return g2vo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 삽입
	public static int getInsert(GuestBook2VO g2vo) {
		try {
			int result = 0;
			result = getSession().insert("guestbook2.insert", g2vo);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	// 삭제
	public static int getDelete(String idx) {
		try {
			int result=0;
			result=getSession().delete("guestbook2.delete", idx);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	// 수정
	public static int getUpdate(GuestBook2VO g2vo) {
		try {
			int result = 0;
			result=getSession().update("guestbook2.update", g2vo);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
