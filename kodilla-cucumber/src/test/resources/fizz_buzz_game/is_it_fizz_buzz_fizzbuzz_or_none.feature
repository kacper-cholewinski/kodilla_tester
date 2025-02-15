Feature:  Is it Fizz, Buzz, FizzBuzz or None?

  Scenario Outline: It is Fizz, or Buzz, or FizzBuzz or None
    Given number is <number>
    When I ask whether it's Fizz, Buzz, FizzBuzz or None
    Then the answer should be <answer>
    Examples:
      | number | answer |
      | 0      | "FizzBuzz"   |
      | 1      | "None"   |
      | 3      | "Fizz"   |
      | 4      | "None"   |
      | 5      | "Buzz"   |
      | 6      | "Fizz"   |
      | 9      | "Fizz"   |
      | 10     | "Buzz"   |
      | 12     | "Fizz"   |
      | 15     | "FizzBuzz" |
      | 20     | "Buzz"     |
      | 35     | "Buzz"     |
      | 63     | "Fizz"     |
      | 150    | "FizzBuzz" |
      | 263    | "None"     |

