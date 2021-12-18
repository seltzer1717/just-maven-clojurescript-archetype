(ns com.foo.aws.test-suite
  (:require [com.foo.aws.core-test :as c]
            [cljs.test :refer-macros [run-tests]]))

(run-tests 'cloud.seltzer1717.clojure.godsplan.core-test)