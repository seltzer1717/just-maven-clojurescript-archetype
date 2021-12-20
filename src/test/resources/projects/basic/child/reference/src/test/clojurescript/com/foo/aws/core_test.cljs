(ns com.foo.aws.core-test
  (:require [com.foo.aws.core :as c]
            [cljs.test :refer-macros [deftest is testing run-tests]]))

(deftest test-reverso (is (= "blah" (c/reverso "halb"))))

