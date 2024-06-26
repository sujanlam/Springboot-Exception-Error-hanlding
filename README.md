1) Create a class ApplicationExceptionHandler and annotate it with @RestControllerAdvice
2) @ResponseStatus(HttpStatus.BAD_REQUEST) => annotate with status to mention what will be returned
3) @ExceptionHandler(MethodArgumentNotValidException.class) => mention which error is to be thrown
4) On 2 and 3 => based on what error and exception mentioned in the annotation, the annotated method will be called
Here, 
5) If MethodArgumentNotValidException is met, it will call the following method: handleInvalidArgument
6) If UserNotFoundException is met, it will call the following method: notFoundExceptionHandler
=======================================================================================================

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
    errorMap.put(error.getField(), error.getDefaultMessage());
    });
    return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> notFoundExceptionHandler(UserNotFoundException ex){
        Map<String, String> errorMap = new HashMap<>();
            errorMap.put("Error message:", ex.getMessage());
        return errorMap;
    } 
===========================================================================
   7) Also, add @Valid to the method in controller:
      @PostMapping("/signup")
      public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
      }
   8) Need to create this class to override the method in Exception class just to display the message
      public class UserNotFoundException extends Exception{

      public UserNotFoundException(String message){
      super(message);
      }
      }
