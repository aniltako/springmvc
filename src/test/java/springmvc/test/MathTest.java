package springmvc.test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import test.Calculation;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class MathTest {
	
	@Mock
	Calculation mathObj;
	
	@Test
	public void create(){
		MockitoAnnotations.initMocks(this);
//		Calculation cal = Mockito.mock(Calculation.class);
		
		Mockito.when(mathObj.add(4, 4)).thenReturn(8);
		
		assertSame(8, mathObj.add(4, 4));
	}

}
