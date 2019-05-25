Given: correct student grade format string 
When: parse 
Then: return student grade info

Given: not correct student grade format string
When: parse
Then: return none

Given: a student grade info
When: save
Then: return true

Given: a student grade info and have existed system
When: save
Then: return false

Given: some student id
When: find
Then: return that grade infos

Given: some student grade infos
When: generate report
Then: return student grade report

Given: student grade report
When: format report
Then: return report string

Given: student ids string
When: parse
Then: return student id list
