package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  TorpedoStore primaryMock;
  TorpedoStore secondaryMock;  
  private GT4500 ship;

  @BeforeEach
  public void init() {
    this.primaryMock = mock(TorpedoStore.class);
    this.secondaryMock = mock(TorpedoStore.class);
    this.ship = new GT4500(primaryMock, secondaryMock);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(primaryMock.fire(1)).thenReturn(true);
    when(primaryMock.isEmpty()).thenReturn(false);


    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primaryMock.isEmpty()).thenReturn(false);
    when(primaryMock.getTorpedoCount()).thenReturn(10);
    when(primaryMock.fire(10)).thenReturn(true); 
    
    when(secondaryMock.isEmpty()).thenReturn(false);
    when(secondaryMock.getTorpedoCount()).thenReturn(10);
    when(secondaryMock.fire(10)).thenReturn(true);     

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
