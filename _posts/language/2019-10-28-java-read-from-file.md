Let's start with a simple way to read from file using BufferedReader; the file itself contains:

The following code reads from the file using BufferedReader:

```java 
@Test
public void whenReadWithBufferedReader_thenCorrect()
  throws IOException {
     String expected_value = "Hello world";
     String file ="src/test/resources/test_read.txt";
      
     BufferedReader reader = new BufferedReader(new FileReader(file));
     String currentLine = reader.readLine();
     reader.close();
 
    assertEquals(expected_value, currentLine);
}
```


Note that readLine() will return null when the end of the file is reached.


```java
BufferedReader objReader = null;
  try {
   String strCurrentLine;

   objReader = new BufferedReader(new FileReader("D:\\DukesDiary.txt"));

   while ((strCurrentLine = objReader.readLine()) != null) {

    System.out.println(strCurrentLine);
   }

  } catch (IOException e) {

   e.printStackTrace();

  } finally {

   try {
    if (objReader != null)
     objReader.close();
   } catch (IOException ex) {
    ex.printStackTrace();
   }
  }
```