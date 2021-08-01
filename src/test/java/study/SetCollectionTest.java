package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void SseUp(){

        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항1
    @DisplayName("set 크기")
    @Test
    public void setSize() throws Exception{

        assertThat(numbers.size()).isEqualTo(3);
    }



    // 요구사항2
    @DisplayName("set 값 확인")
    @Test
    public void contains() throws Exception{
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    // 요구사항2 - @ParameterizedTest
    @DisplayName("set 값 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void contains2(int num) throws Exception {

        assertThat(numbers.contains(num)).isTrue();

    }


    // 요구사항2 - @CsvSource
    @DisplayName("set 값 확인")
    @ParameterizedTest(name = "#{index} - Test with Argument={arguments}")
    @CsvSource(value = {"1:true","2:true","3:true", "4:false", "5:false"}, delimiter = ':')
    public void contains_csv(String input, boolean expected) throws Exception {

        boolean b = Integer.parseInt(input) < 4;
        //String s = String.valueOf(b);
        assertThat(b).isEqualTo(expected);
    }



}
