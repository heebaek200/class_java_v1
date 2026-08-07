package practice.managephonenumber;

import java.util.LinkedList;

// 전화번호부 클래스
public class PhoneBook {

    // 전화번호 레코드
    private LinkedList<PhoneBookEntry> records = new LinkedList<>();

    // 레코드 최대치 제한
    public static int MAXIMUM = 100;

    public PhoneBook() {
        // 테스트 데이터 입력

        records.add(new PhoneBookEntry("김피카츄", "010-1234-1241"));
        records.add(new PhoneBookEntry("김라이츄", "010-5422-7283"));
        records.add(new PhoneBookEntry("이꼬부기", "010-3735-8508"));
        records.add(new PhoneBookEntry("박파이리", "010-2353-7820"));
        records.add(new PhoneBookEntry("최이상해씨", "010-0824-7897"));
        records.add(new PhoneBookEntry("정마스카나", "010-2789-9952"));
        records.add(new PhoneBookEntry("강라우드본", "010-2968-0404"));
    }

    // 레코드 최대치를 넘지 않아 여유공간이 있는지 판단
    public boolean checkSpace() {
        if (records.size() >= MAXIMUM) {
            return false;
        } else {
            return true;
        }

    }

    // 조회, 수정, 삭제를 위한 레코드 1개를 이름으로 조회하여 get. trim 적용
    public PhoneBookEntry getEntryByName(String searchName) {
        searchName = searchName.trim();

        for (PhoneBookEntry entry: records) {
            if (entry.getEntryName().equals(searchName)) {
                return entry;
            }
        }

        return null;
    }


    // 등록
    public PhoneBookEntry create(String entryName, String phoneNumber) {

        PhoneBookEntry newPhoneBookEntry = new PhoneBookEntry(entryName, phoneNumber);
        records.add(newPhoneBookEntry);

        return newPhoneBookEntry;
    }

    // 전체 조회
    public int readAll() {
        for (PhoneBookEntry entry: records) {
            entry.showInfo();
        }

        return records.size();
    }

    // 전체 삭제
    public void deleteAll() {
        records.clear();
    }

    // 선택 삭제
    public void deleteOne(PhoneBookEntry entry) {
        records.remove(entry);
    }


}
