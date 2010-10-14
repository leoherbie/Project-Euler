; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
; The sum of these multiples is 23.
;
; Find the sum of all the multiples of 3 or 5 below 1000.
;******************************************************************************************************

; first attempt
(println
  (time
   (apply +
    (filter
     #(or (not (ratio? (/ % 5))) (not (ratio? (/ % 3))))
     (range 3 1000)))))

;******************************************************************************************************

; second attempt (after reading PE solution)
(defn sum-divisible-by [n target]
  (let [p (quot target n)]
    (/ (* n (* p (+ p 1))) 2)
    )
  )

(println
  (time(- (+ (sum-divisible-by 3 999) (sum-divisible-by 5 999)) (sum-divisible-by 15 999))))


