; 2�? = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;
; What is the sum of the digits of the number 2�????

; first attempt
(ns problems
  (:use [common :only (sum-of-digits-of-num)]))

(println (time (sum-of-digits-of-num (BigDecimal. (Math/pow 2 1000)))))
