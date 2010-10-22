; 2¹? = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;
; What is the sum of the digits of the number 2¹????

; first attempt
(defn sum-of-digits-of-num [num]
  (reduce #(+ (Integer/valueOf (str %1)) (Integer/valueOf (str %2))) (.toPlainString (BigDecimal. (double num)))))

(println (time (sum-of-digits-of-num (Math/pow 2 1000))))
