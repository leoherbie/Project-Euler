; A palindromic number reads the same both ways. The largest palindrome made from the product
; of two 2-digit numbers is 9009 = 91 × 99.
;
; Find the largest palindrome made from the product of two 3-digit numbers.
;******************************************************************************************************

; first attempt
(defn str-reverse [string]
  "reverses a string. not unicode safe."
  (apply str (reverse string)))

(defn palindrome? [string]
  "tests if a string is a palindrome. the object passed in will be coerced into a string for comparison."
  (= (str string) (str-reverse (str string))))

(defn create-largest-num-for-length [length]
  "creates the largest number for a passed in length (ie. length = 2; returns 99)"
  (Integer/valueOf (apply str (repeat length 9))))

(defn create-smallest-num-for-length [length]
  "creates the smallest number for a passed in length (ie. length = 2; returns 10)"
  (Integer/valueOf (str "1" (apply str (repeat (- length 1) 0)))))

(defn find-largest-palindrome [digit-size]
  "finds the largest palindrome from the product of two numbers
  which have a length equaling the digit-size
  digit-size must be >= 2"
   (let [start (create-largest-num-for-length digit-size) end (create-smallest-num-for-length digit-size)
     nums (take (- start (- end 1)) (iterate dec start))]
     (loop [to-process nums largest 0]
       (if (empty? to-process)
         largest
         (do (let [cur_largest (first (reverse (sort (filter palindrome? (map #(* % (first to-process)) to-process)))))]
           (recur (rest to-process) (if (and (not (nil? cur_largest)) (> cur_largest largest)) cur_largest largest))))))))

(println (time (find-largest-palindrome 3)))