package practice.managephonenumber;

/**
 * 전화번호부의 이름과 전화번호의 레코드
 */
public class PhoneBookEntry {

    // 레코드 이름
    private String entryName;

    // 레코드 전화번호
    private String phoneNumber;

    // 생성자 (이름과 전화번호 초기화. .trim() 적용)
    public PhoneBookEntry(String entryName, String phoneNumber) {
        this.entryName = entryName.trim();
        this.phoneNumber = phoneNumber.trim();
    }

    // 정보를 콘솔에 출력
    public void showInfo() {
        System.out.printf("이름: %s / 전화번호: %s\n", entryName, phoneNumber);
    }

    // 레코드 하나를 수정
    public void update(String entryName, String phoneNumber) {
        setEntryName(entryName);
        setPhoneNumber(phoneNumber);
    }

    // getter of entryName
    public String getEntryName() {
        return entryName;
    }

    // setter of entryName
    public void setEntryName(String entryName) {
        this.entryName = entryName.trim();
    }

    // getter of phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setter of phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

}
