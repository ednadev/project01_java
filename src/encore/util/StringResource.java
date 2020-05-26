package encore.util;

public class StringResource {
	public final String codeNum = "778899";
	public final String strMode = "누구신가요? 1.학생\t2.관리자";
	public final String notstr = "숫자만 입력이 가능합니다.";
	public final String codeCheck = "코드를 입력해주세요!";
	public final String notCode = "코드가 틀렸습니다.";
	public final String menuStu = "학생입니다.\n1.수강신청\t\t2.신청조회\t\t3.신청수정\t\t4.신청취소";
	public final String menuGm = "관리자입니다.\n1.강좌추가\t\t2.조회\t\t3.수정\t\t4.삭제";
	public final String [] addCurriculum = {"강좌명을 입력하세요.","강좌일수를 입력하세요.","강좌에 사용될 언어를 입력하세요.\t종료(0)"}; 
	public final String comAdd = "등록이 완료되었습니다.";
	public final String selectCclum = "삭제할 강좌코드를 선택해주세요.";
	public final String comDelete = "삭제가 완료되었습니다.";
	public final String failedCclum = "존재하지 않는 강좌코드입니다.";
	public final String updateCclum = "1.강좌명 수정\t\t2.기간 수정\t\t3.과목 수정";
	public final String selectUpdate = "수정할 강좌코드를 선택해주세요.";
	public final String updateCclumName = "수정할 강좌명을 입력해주세요.";
	public final String updateCclumTerm = "수정할 기간을 입력해주세요.";
	public final String updateCclumLan = "수정할 과목을 입력해주세요.";
	public final String [] addStudent = {"이름을 입력하세요.", "전공을 입력하세요.", "핸드폰번호를 입력하세요."};
	public final String updateStudent = "수정할 학생코드를 입력해주세요.";
	public final String updateStudentList = "1.전공 수정\t\t2.핸드폰번호 수정\t\t3.강좌 수정";
	public final String updateStudentMajor = "수정할 전공을 입력해주세요.";
	public final String updateStudentPhone = "수정할 핸드폰번호를 입력해주세요.";
	public final String updateStudentCclum = "수정할 강좌코드를 입력해주세요.";
	public final String failedStudent = "존재하지 않는 학생입니다.";
	public final String searchStudentName = "조회할 이름을 입력해주세요.";
	public final String searchStudentPhone = "핸드폰번호를 입력해주세요.";
	public final String deleteStudent = "삭제할 학생코드를 입력해주세요.";
	public final String searchStudentCclum = "수강할 강좌코드를 입력해주세요.";
	public final String searchStudentList = "1.수강인원 조회\t\t2.조건검색";
	public final String insertCode = "강좌코드를 입력해주세요.";
	public final String failedInsertCode = "수강인원이 없습니다.";
	public final String searchSelectCclum = "1.이름\t\t2.번호\t\t3.출석";
	public final String failedPhone = "잘못된 번호입니다.";
	public final String searchCheck = "1.전체\t\t2.미달\t\t3.합격";
	public final String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
}
