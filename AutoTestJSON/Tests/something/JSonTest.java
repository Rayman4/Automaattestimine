package something;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.json.simple.JSONArray;
import org.junit.Test;
import org.mockito.Mockito;


public class JSonTest {

    @Test
    public void Test1(){
        JSon jSon = new JSon();
        assertEquals("Ilma mockimata",300,jSon.getData());
    }

    @Test
    public void Mock1(){
        JSon jason = Mockito.spy(JSon.class);
        jason.getData();
        verify(jason, times(1)).getCommentsArraySize();
        verify(jason, times(1)).getTodosArraySize();
    }

    @Test
    public void Mock2(){
        JSon mockingJ = Mockito.mock(JSon.class);
        when(mockingJ.getData()).thenCallRealMethod();
        when(mockingJ.getCommentsArraySize()).thenReturn(600);
        when(mockingJ.getTodosArraySize()).thenReturn(200);
        assertEquals("Mocki kasutamine", 400, mockingJ.getData());

    }



}