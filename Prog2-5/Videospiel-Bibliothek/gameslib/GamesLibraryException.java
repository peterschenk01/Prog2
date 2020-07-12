package gameslib;

public class GamesLibraryException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public GamesLibraryException(String message, Throwable cause){
    super(message, cause);
  }

  public GamesLibraryException(String message){
    super(message);
  }

  public GamesLibraryException(Throwable cause){
    super(cause);
  }

}
