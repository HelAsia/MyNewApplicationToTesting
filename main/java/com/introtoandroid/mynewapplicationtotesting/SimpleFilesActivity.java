package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SimpleFilesActivity extends Activity {
  private static final String DEBUG_TAG = "SimpleFilesActivity";
  private static final String SOME_FILE_CONTENTS = "Żółwie morskie można spotkać na całym świecie, "
      + "lecz wszystkie ich gatunki są na listach gatunków zagrożonych. Należy do nich także żółw Karetta.";
  private static final String MORE_FILE_CONTENTS = "Żółwie Karettta rodzą się na Pacyfiku, na plażach wysp "
      + "japońskich. Małe żółwiki wykluwają się z jaj w nocy, co ma je ochronić przed wypatrzeniem przez "
      + "drapieżniki i pożarciem. Wędrują do oceanu podążając w stronę światła. W przeszłości najjaśniejszym "
      + "światłem w nocy było samo morze, jednak obecnie światła używane przez ludzi mogą mylić małe żółwie "
      + "i zakłócać ich wędrówkę do oceanu. Jedynie części z nich udaje się pokonać piaszczystą plażę "
      + "i bezpiecznie dotrzeć do wody.";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_files);

    runFileAccessExample();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_simple_files, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public void runFileAccessExample() {
    Log.i(DEBUG_TAG, "Begin File Example");
    String file1 = "files.txt";
    if (Arrays.binarySearch(fileList(), file1) >= 0) {
      deleteFile(file1);
    }

    FileOutputStream fos;
    try {
      fos = openFileOutput(file1, MODE_PRIVATE);
      fos.write(SOME_FILE_CONTENTS.getBytes());
      fos.close();
      Log.i(DEBUG_TAG, "You saved text in file: " + file1);
    }catch (Exception e){
      Log.i(DEBUG_TAG, "openFileOutput (new file) throws exception: " + e.getMessage());
    }

    readAppFileAndLog(file1);

    readAppFileAndLogAsString(file1);

    try {
      fos = openFileOutput(file1, MODE_APPEND);
      fos.write(MORE_FILE_CONTENTS.getBytes());
      fos.close();
      Log.i(DEBUG_TAG, "You added text in file: " + file1);
    }catch (Exception e){
      Log.i(DEBUG_TAG, "openFileOutput (new file) throws exception: " + e.getMessage());
    }

    readAppFileAndLog(file1);
    Log.i(DEBUG_TAG, "INSPECTING APPLICATION FILE DIRECTORY at Context.getFilesDir()");
    File pathForAppFiles = getFilesDir();
    logFileDetails(pathForAppFiles);

    Log.i(DEBUG_TAG, "Display files in catalog " + pathForAppFiles.getAbsolutePath());
    String[] fileList = pathForAppFiles.list();
    for (int i = 0; i < fileList.length; i++) {
      Log.i(DEBUG_TAG, "File" + i + ":" + fileList[i]);
    }

    Log.i(DEBUG_TAG, "Checking app directory which was determined by calling Context.getCacheDir()");
    File pathCacheDir = getCacheDir();
    logFileDetails(pathCacheDir);

    String strCacheFileName = "my.CacheFile.cache";
    File newCacheFile = new File(pathCacheDir, strCacheFileName);

    try{
      Log.i(DEBUG_TAG, "We are creating a new file in the cache directory " + strCacheFileName);
      final boolean newFile = newCacheFile.createNewFile();
      Log.i(DEBUG_TAG, "Created new file in the cache directory: " + newFile);
      logFileDetails(newCacheFile);

      FileOutputStream foCache = new FileOutputStream(newCacheFile.getAbsolutePath());
      foCache.write(SOME_FILE_CONTENTS.getBytes());
      foCache.close();

      Log.i(DEBUG_TAG, "Saved file: ");
      readAnyFileAndLog(newCacheFile.getAbsolutePath());
    }catch (Exception e) {
      Log.i(DEBUG_TAG, "Call createNewFile throws exception: " + e.getMessage());
    }

    Log.i(DEBUG_TAG, "Display files in directory " + pathCacheDir.getAbsolutePath());
    String[] fileListCache = pathCacheDir.list();
    for(int i = 0; i < fileListCache.length; i++)
      Log.i(DEBUG_TAG, "Delete file in the cache directory: " + strCacheFileName);
    final boolean cacheDelete = newCacheFile.delete();
    Log.i(DEBUG_TAG, "Deleted file in the cache directory: " + cacheDelete);

    Log.i(DEBUG_TAG, "Display files in directory " + pathCacheDir.getAbsolutePath());
    String[] fileListCacheRefeshed = pathCacheDir.list();
    for(int i=0; i< fileListCacheRefeshed.length; i++)        {
      Log.i(DEBUG_TAG, "File " + i+": " + fileListCacheRefeshed[i] );
    }

    Log.i(DEBUG_TAG, "Try to delete created file: " + file1);
    if (deleteFile(file1)) {
      Log.i(DEBUG_TAG, "Delete file: " + file1 + ".");
    }

    Log.i(DEBUG_TAG, "The end of example which presented operations on files.");
  }

  public void logFileDetails(File file)	{
    if(file.isDirectory())        {
      Log.i(DEBUG_TAG, file.getAbsolutePath() + " is DIRECTORY");
    }
    if(file.isFile())        {
      Log.i(DEBUG_TAG, file.getAbsolutePath() + " is FILE");
    }
    if(file.isHidden())        {
      Log.i(DEBUG_TAG, file.getAbsolutePath() + " is HIDDEN FILE");
    }
    if(file.exists())        {
      Log.i(DEBUG_TAG, file.getAbsolutePath() + " EXISTS");
    }
    if(file.canRead())        {
      Log.i(DEBUG_TAG, file.getAbsolutePath() + " CAN READ");
    }
    if(file.canWrite())        {
      Log.i(DEBUG_TAG, file.getAbsolutePath() + " CAN WRITE");
    }
  }

  public void readAppFileAndLog(String filename) {
    FileInputStream fis;

    try {
      fis = openFileInput(filename);
      StringBuffer sBuffer = new StringBuffer();
      int chunkSize = 70;
      byte[] bf = new byte[chunkSize];

      while ((fis.read(bf, 0, chunkSize)) != -1) {
        String str = new String(bf);
        sBuffer.append(str);
        sBuffer.append("\n");
        if(fis.available() < 50)
        {
          Arrays.fill(bf, 0, chunkSize, (byte) ' '); // Czyścimy bufor, dzięki czemu następny wiersz tekstu będzie zawierał wyłącznie pozostałe bajty.
        }
      }
      fis.close();

      Log.i(DEBUG_TAG, "Zawartość pliku:\n" + sBuffer.toString());
      Log.i(DEBUG_TAG, "\nEOF");
    } catch (Exception e) {
      Log.i(DEBUG_TAG, "Wywołanie openFileInput zgłosiło wyjątek: "+ e.getMessage());
    }
  }

  public void readAnyFileAndLog(String filename) {
    FileInputStream fis;

    try {
      fis = new FileInputStream(filename);
      StringBuffer sBuffer = new StringBuffer();
      int chunkSize = 70;
      byte[] bf = new byte[chunkSize];

      while ((fis.read(bf, 0, chunkSize)) != -1) {
        String str = new String(bf);
        sBuffer.append(str);
        sBuffer.append("\n");
        if(fis.available() < 50)
        {
          Arrays.fill(bf, 0, chunkSize, (byte) ' ');
        }
      }

      fis.close();

      Log.i(DEBUG_TAG, "Zawartość pliku:\n" + sBuffer.toString());
      Log.i(DEBUG_TAG, "\nEOF");
    } catch (Exception e) {
      Log.i(DEBUG_TAG, "Wywołanie openFileInput zgłosiło wyjątek: "+ e.getMessage());
    }
  }

  public void readAppFileAndLogAsString(String filename) {
    FileInputStream fis;

    try {
      fis = openFileInput(filename);
      StringBuffer sBuffer = new StringBuffer();
      BufferedReader dataIO = new BufferedReader(new InputStreamReader(fis));
      String strLine;

      while ((strLine = dataIO.readLine()) != null) {
        sBuffer.append(strLine);
        sBuffer.append("\n");
      }

      dataIO.close();
      fis.close();

      Log.i(DEBUG_TAG, "Zawartość pliku:\n" + sBuffer.toString());
      Log.i(DEBUG_TAG, "\nEOF");
    } catch (Exception e) {
      Log.i(DEBUG_TAG, "Wywołanie openFileInput zgłosiło wyjątek: "+ e.getMessage());
    }
  }
}
