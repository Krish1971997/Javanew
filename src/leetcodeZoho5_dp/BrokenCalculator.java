package leetcodeZoho5_dp;

public class BrokenCalculator {
	public static void main(String[] args) {
		int startValue = 3;
		int target = 10;
		System.out.println(brokenCalc(startValue, target));
	}

	public static int brokenCalc(int startValue, int target) {
		int ops = 0;

		// Work backwards from target until it is <= startValue
		while (startValue < target) {
			if (target % 2 == 0) {
				target /= 2;
			} else {
				target += 1;
			}
			ops++;
		}

		// Now if startValue >= target, we just need (startValue - target) subtractions
		ops += startValue - target;
		return ops;
	}
}

/**

இது LeetCode **Broken Calculator** problem-க்கு interview-ல எப்படி explain பண்ணலாம் என்பதற்கான **தமிழ் explanation** (logic + why + how it works).
இதை நீங்கள் interview-ல நன்றா சொல்லலாம்.

---

# ⭐ Interview Explanation in Tamil (Simple + Clear)

## 🔥 **Problem Recap (1–2 lines)**

“நமக்கு startValue இருந்து target value வுக்கு செல்ல இரண்டு operations மட்டும் இருக்கு:

1. ×2
2. −1
   Minimum stepsல சென்றாகணும்.”

---

# ⭐ Why Reverse Approach? (Main Interview Point)

**Forward directionல** (startValue → target) சென்றா

* இரண்டு operations இருக்கு
* எந்த operation செய்யணும் என்று predict பண்ண முடியாது
* brute force, BFS, recursion எல்லாம் slow ஆகிடும்
* target mass-ஆ பெரிய number இருந்தா impossible (TLE)

**அதனால் நாம reverse-ஆ solve பண்ணுறோம்** → (target → startValue)

**ஏன் reverse easier?**
Reverse directionல நமக்கு ஒரு clarity வரும்:

### 👉 Case 1: **target > startValue**

#### If target even:

target evenனா 100% last operation "2x" தான்.

உதாரணம்:

```
startValue: 3
target: 10
```

10 even → last step must be 5 * 2 → 10
Reverse → 10 / 2 = 5

#### If target odd:

target odd → last operation “-1” தான்
(ஏனென்றால் 2x செய்தால் odd number வராது)

உதாரணம்:

```
target = 11 (odd)
Last operation must be 12 - 1 → 11
Reverse → 11 + 1 = 12
```

**இந்த இரண்டு rulesலே entire problem முடிஞ்சிடுது.**

---

# ⭐ How the logic works? (Step-by-step reasoning)

### 🔸 While target > startValue:

* target evenனா → divide by 2
* target oddனா → target + 1

(இதற்கு ஒரு operation count)

### 🔸 target <= startValue ஆனவுடன்:

மீதமுள்ள difference நம்மாலே direct-ஆ subtraction (startValue - target) Steps.

**ஏன் direct subtraction?**
target < startValue வந்தவுடன் நமக்கு multiply செய்ய தேவையில்லை.
இப்போ ஒரே option → subtract 1.

---

# ⭐ Interview-level Explanation (சிறந்த பதில்)

**English + Tamil mix (professional tone):**

“இந்த problem-ல forward directionல solve பண்ணும்போது
operation என்ன செய்யணும் என்பதை predict பண்ண முடியாது.
ஆனாலும் reverse directionல solve பண்ணினா result guarantee-ஆ கிடைக்கும்.

target > startValue இருக்கும்போது

* target even என்றால் அது 2x operation மூலம் வந்தது. நான் reverse-ஆ /2 பண்ணிக்கலாம்.
* target odd என்றால் அது -1 operation மூலம் வந்தது. Reverse-ஆ நான் +1 பண்ணிக்கலாம்.

இதனால தான் நாம reverse-ஆ solve பண்ணுறோம்.
இந்த இரண்டு conditionsலே target value minimum steps-ல startValue க்கு அருகில் கொண்டு வர முடிகிறது.
target startValue விட குறையா வந்தவுடன் remaining steps வெறும் difference தான், direct subtract.
So total steps = reverse operations + (startValue - target).
இந்த approach O(log n) நேரத்தில் வேலை செய்கிறது.”

---

# ⭐ Tamil Example Explanation (interviewer கேட்டால்)

Example:
start = 3
target = 10

```
10 even → /2 = 5   (ops = 1)
5 > 3 and odd → +1 = 6 (ops = 2)
6 even → /2 = 3    (ops = 3)
இப்போ target == startValue.
```

Minimum steps = 3

---

# ⭐ Final Short Answer (interview-ல quick-ஆ சொல்ல)

“Forward directionல choices uncertain, but reverse directionல deterministic.
Target evenனா /2, oddனா +1.
இதனால greedy reverse approach தான் minimum steps க்கு guarantee.
Target startValue விட small or equal ஆன உடனே difference steps directly subtract செய்து முடித்துவிடலாம்.”

---

வேணும்னா இதே problem-க்கு **visual diagram explanation** or **handwritten-style notes** க்கும் செய்து தரேன்.


**/
