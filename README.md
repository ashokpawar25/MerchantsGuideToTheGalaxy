# MerchentGuide

Merchant's Guide to the Galaxy
 
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
Symbol     Value
  I         1
  V         5
  X        10
  L        50
  C        100
  D        500
  M       1,000

Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
 
The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)
 
Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
You are expected to handle invalid queries appropriately.
 
Test input:
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
 
Test Output:
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

# Package : Domain (Having information of models and services)

# Models:

# IntergalacticTransactionUnit

## States
- `private String intergalacticValue`
- `private String romanValue`
- `private int actualValue`

## Constructors
- `public IntergalacticTransactionUnit(String intergalacticValue, String romanValue, int actualValue)`
- `public static IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue)`

## Behaviors
- `public String getIntergalacticValue()`
- `public String getRomanValue()`
- `public int getActualValue()`
- `@Override public boolean equals(Object o)`

# Metal

## States
- `private String name`
- `private long credits`

## Constructors
- `public Metal(String name, long credits)`
- `public static Metal create(String name, long credits)`

## Behaviors
- `public String getName()`
- `@Override public boolean equals(Object o)`

# Validator (validate the states of models)

# IntergalacticTransactionUnitValidator

## Behaviors
- `public static boolean isInvalidIntergalacticValue(String intergalacticValue)`
- `public static boolean isInvalidRomanValue(String romanValue)`

# MetalValidator

## Behaviors
- `public static boolean isInvalidMetalName(String name)`
- `public static boolean isInvalidCredits(long credits)`

# IOService

## States
- `IntergalacticTransactionUnitService intergalacticUnitService`
- `MetalService metalService`

## Constructors
- `public IOService(IntergalacticTransactionUnitService intergalacticTransactionUnitService, MetalService metalService)`

## Behaviors
- `public boolean readFile(String filePath)`

# InputParser

## Behaviors
- `public static IntergalacticUnitDto parseUnit(String line) throws IOException`
- `public static MetalDto parseMetal(String line, IntergalacticTransactionUnitService intergalacticUnitService) throws IOException`

# InputValidator

## Behaviors
- `public static boolean unitValidator(String line) throws IOException`
- `public static boolean metalCreditsValidator(String line) throws IOException`

# UnitConverter

## Behaviors
- `public static long romanToDecimalConverter(StringBuilder romanValue)`
- `public static long DecimalToRomanConverter(long decimalValue)`

# Controller (Delegating operations of enitities)

# IntergalacticTransactionUnitController

## States
- `IntergalacticTransactionUnitService intergalacticTransactionUnitService`

## Constructors
- `public IntergalacticTransactionUnitController(IntergalacticTransactionUnitService intergalacticTransactionUnitService)`

## Behaviors
- `public Response create(String intergalacticValue, String romanValue, int actualValue)`
- `public IntergalacticTransactionUnit get(String intergalacticValue)`

# MetalController

## States
- `MetalService metalService`

## Constructors
- `public MetalController(MetalService metalService)`

## Behaviors
- `public Response create(String name, long credits)`
- `public Metal getMetal(String name)`
# IOController

## States
- `IOService ioService`

## Constructors
- `public IOController(IOService ioService)`

## Behaviors
- `public boolean readFile(String filePath)`

# controller/dto (used to send http response from the controller)

# Response

## States
- `HttpStatus httpStatus`
- `String message`

## Constructors
- `public Response(HttpStatus httpStatus, String message)`

## Behaviors
- `@Override public boolean equals(Object o)`


# HttpStatus

## Enum Values
- `BADREQUEST`
- `CONFLICT`
- `OK`

# Service( It is layer between controller and repository)

# IntergalacticTransactionUnitService

## States
- `IntergalacticTransactionUnitRepository intergalacticTransactionUnitRepository`

## Constructors
- `public IntergalacticTransactionUnitService(IntergalacticTransactionUnitRepository intergalacticTransactionUnitRepository)`

## Behaviors
- `public IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue)`
- `public IntergalacticTransactionUnit get(String intergalacticValue)`

# MetalService

## States
- `MetalRepository metalRepository`

## Constructors
- `public MetalService(MetalRepository metalRepository)`

## Behaviors
- `public Metal create(String name, long credits)`
- `public Metal getMetal(String name)`

# Repository (Abstration between database and service)

# IntergalacticTransactionUnitRepository

## Behaviors
- `IntergalacticTransactionUnit add(String intergalacticValue, String romanValue, int actualValue)`
- `IntergalacticTransactionUnit find(String intergalacticValue)`

# MetalRepository

## Behaviors
- `Metal add(String name, long credits)`
- `Metal selectFromMetalTable(String name)`

# Database (Storing actal database)

# InMemoryDatabase

## Behaviors
- `IntergalacticTransactionUnit InsertIntoIntergalacticTransactionUnitTable(String intergalacticValue, String romanValue, int actualValue)`
- `IntergalacticTransactionUnit selectFromIntergalacticTransactionUnitTable(String intergalacticValue)`
- `Metal InsertIntoMetalTable(String name, long credits)`
- `Metal selectFromMetalTable(String name)`
