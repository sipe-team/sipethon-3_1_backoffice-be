package team.sipe.office.global;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringSplitTest {
    @Test
    void test() {
        String descriptions = "격주 토요일 오후 2시 ~ 6시에 진행되는 정규 활동에 성실하게 참여할 수 있는|자신의 지식과 경험을 다른 구성원들과 적극적으로 공유하고 소통할 수 있는|다양한 경험을 가진 사람들과 폭넓고 깊이 있는 대화를 나누고 싶은";
        final List<String> list = Arrays.stream(descriptions.split("\\|")).toList();
        list.forEach(System.out::println);

    }
}
