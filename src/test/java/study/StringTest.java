package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항1
    @Test
    public void split() throws Exception{

        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
    }

    // 요구사항2
    @Test
    public void substring() throws Exception{

        String aa = "(1,2)";
        String substring = aa.substring(1, aa.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    // 요구사항3
    @DisplayName("위치값을 벗어나면 StringIndexOutBoundsException 예외발생")
    @Test
    public void StringIndexOutBoundsException() throws Exception{
        //given
        
        //when
        
        
        //then
        String abc = "abc";

        assertThatThrownBy(() -> {
            abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
    
}
