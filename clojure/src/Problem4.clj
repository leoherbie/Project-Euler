; A palindromic number reads the same both ways. The largest palindrome made from the product
; of two 2-digit numbers is 9009 = 91 × 99.
;
; Find the largest palindrome made from the product of two 3-digit numbers.
;******************************************************************************************************

;first attempt
(defn str-reverse [string]
  "reverses a string. not unicode safe."
  (apply str (reverse string)))

(defn palindrome? [string]
  "tests if a string is a palindrome"
  (= string (str-reverse string)))

(defn progress-size [num]
  "calulates a numeric length is which to progress with palindrome
  calulation before skipping back to the beginning.
  It is pretty arbitrary right now :-)"
  (Math/floor (/ num 10)))

(defn create-largest-num-for-length [length]
  "creates the largest number for a passed in length"
  (Integer/valueOf (apply str (repeat length 9))))

(defn find-largest-palindrome [digit-size]
  "finds the largest palindrome from the product of two numbers
  which have a length equaling the digit-size
  digit-size must be >= 2"
   (let [l (create-largest-num-for-length digit-size) r l]
     r
     )
  )

;
;  basic approach  first calculate a progress size by floor(dividing number by 10).
;  so for 99 it would be 9.  then test 99 * 99 to (99 - progress-size).  if a palindrome is found.
;  save it b/c it might not be the largest.
;  Then start from (99-1 * 99-1) to 99-progress-size *  99-progress-size
;
;  so assuming no palindrome is found (which we know will be in this case) the following calulations would happen:
;
;  99 * 99
;     .
;     .
;     .
;  99 * 91
;  .......
;  98 * 98
;     .
;     .
;     .
;  91 * 91
;
;  also if a palindrome is found during the first pass it IS the largest if the second pass gets to
;  99-floor(progress-size/2) *  99-floor(progress-size/2)
;
;

(println (time (find-largest-palindrome 2)))