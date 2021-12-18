(ns com.foo.aws.core-test
  (:require [com.foo.aws.core :as c]
            [cljs.test :refer-macros [deftest is]]))

(deftest test-numbers
  (is (= 5 (c/my-add [2 3]))))
