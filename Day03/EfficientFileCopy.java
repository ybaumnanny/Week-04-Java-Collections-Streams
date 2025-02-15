import java.io.*;
public class EfficientFileCopy{

        // Method to copy a file using unbuffered streams
        public static long copyFileUnbuffered() {
            // calculate startTime
            long startTime = System.nanoTime();
            // Create FileInputStream to read the source file
            // Create FileOutputStream to write to the destination file
            try(FileInputStream fis = new FileInputStream("D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Input.txt");
                FileOutputStream fos = new FileOutputStream("D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Output.txt")){
                int byteData;
                // Read from input file and write to the output file
                while((byteData = fis.read()) != -1){
                    fos.write(byteData);
                }
                System.out.println("File copied successfully");
            }catch (FileNotFoundException e){
                e.printStackTrace();;
            } catch (IOException e){
                e.printStackTrace();
            }
            // calculate endTime
            long endTime = System.nanoTime();
            return endTime - startTime;
        }

        // Method to copy a file using buffered streams
        public static long copyFileBuffered(){
            // calculate startTime
            long startTime = System.nanoTime();
            // Create BufferedInputStream to read the source file
            // Create BufferedOutputStream to write to the destination file
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Input.txt"));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Output.txt"))) {
    
                byte[] buffer = new byte[4096];
                int bytesRead;
                // Read from input file and write to the destination file
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
                System.out.println("File copied successfully with buffering.");
            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // calculate endTime
            long endTime = System.nanoTime();
            return endTime - startTime;
        }


        public static void main(String[] args) {

            // Measure Time for buffered file
            long durationOfBufferedFile = copyFileBuffered();
            System.out.println(" Duration of buffered file : " +durationOfBufferedFile+ " ns");
    
            // Measure Time for unbuffered file
            long durationOfUnBufferedFile = copyFileUnbuffered();
            System.out.println(" Duration of buffered file : " +durationOfUnBufferedFile+ " ns");
    
            // Compare
            if(durationOfBufferedFile < durationOfUnBufferedFile ) {
                System.out.println("Buffered file copy is fast");
            }
            else {
                System.out.println("Unbuffered file copy is fast");
            }
        }
    
}
