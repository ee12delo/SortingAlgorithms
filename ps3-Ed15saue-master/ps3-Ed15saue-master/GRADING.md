# Problem Set 3 Grading Sheet

## Total: 38.45/50, after late penalties

* Emprical study code: 12/15, 12 hours late
  * sorting algorithm implementations: 4/4
  * command-line parameters or equivalent: 1/1
  * simulation correctness (i.e., not reusing arrays): 2/2
  * timings: 1.5/2

You are including the time to clone arrays in your sort timings.

  * comparison counts: 1/2

Your comparisons counts appear to be across all trials for a given
algorithm and size combination.

Comparison counts are incorrect for insertion sort. Not counting the
comparison that causes the while loop to exit (when that is why it
exits).

  * output format: 0.5/1

Would be much easier to use your results if you had a very simple output
format.

  * overall style and documentation: 1/2

Almost no documentation in code.

Recommend against variables like your "temp" that clearly should be
locals being declared as class variables.  This can lead to unintended
dependencies.

== comparisons for String values is dangerous.

Why "best = 1048576.0;" ?

  
* Writeup: 28/35, 25 hours late
  * test environment description: 4/4

OK, but only describe it once!

  * methodology introduction: 2/2
  * theoretical expectations for each test case: 6/6
  * complete timings/comparison counts provided: 0/3

Not found.

  * sufficient tabular summaries of results: 0/3

No tabular results found.

  * graphs of results: 6/6
  * analysis of results and relation to theoretical expectations: 5.5/6

Should have said something about insertion sort's best case.

In all cases, point out how you are seeing the n or n^2 behavior.

  * general presentation and writing: 4.5/5

I wouldn't say the recursive versions would be "exponentially slower".

Needs another pass of proofreading and tightening up the writing.
