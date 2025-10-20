
# **Overall Complexity Analysis**

This report consolidates complexity metrics across all packages of the Brewery Problem implementation.  
Metrics include **WMC** (Weighted Methods per Class), **DIT** (Depth of Inheritance Tree), **NOC** (Number of Children), **CBO** (Coupling Between Objects), and **RFC** (Response For a Class).  
All values and interpretations follow the assignment rubric and reflect the current codebase.

---

## 1) Package Summary (Totals)

| Package | Classes | WMC (Total) | DIT (Total) | NOC (Total) | CBO (Total) | RFC (Total) |
|:--|---:|---:|---:|---:|---:|---:|
| **brewery.app** | 3 | 25 | 3 | 0 | 16 | 24 |
| **brewery.inventory** | 2 | 31 | 2 | 0 | 8 | 21 |
| **brewery.plant** | 10 | 49 | 14 | 4 | 18 | 43 |
| **brewery.production** | 5 | 35 | 5 | 0 | 14 | 30 |
| **brewery.recipes** | 4 | 34 | 4 | 0 | 12 | 24 |
| **brewery.services** | 6 | 31 | 8 | 2 | 13 | 24 |
| **Overall** | **30** | **205** | **36** | **6** | **81** | **166** |

## 2) Package Averages (Per Class)

| Package | Avg WMC | Avg DIT | Avg NOC | Avg CBO | Avg RFC |
|:--|---:|---:|---:|---:|---:|
| **brewery.app**        | 8.33 | 1.00 | 0.00 | 5.33 | 8.00 |
| **brewery.inventory**  | 15.50| 1.00 | 0.00 | 4.00 |10.50 |
| **brewery.plant**      | 4.90 | 1.40 | 0.40 | 1.80 | 4.30 |
| **brewery.production** | 7.00 | 1.00 | 0.00 | 2.80 | 6.00 |
| **brewery.recipes**    | 8.50 | 1.00 | 0.00 | 3.00 | 6.00 |
| **brewery.services**   | 5.17 | 1.33 | 0.33 | 2.17 | 4.00 |
| **Overall (avg/class)**| **6.83** | **1.2** | **0.2** | **2.7** | **5.53** |

> Note: Averages are computed per class (package total / number of classes).

---

## 3) Interpretation by Metric

### WMC — Weighted Methods per Class
- **Finding:** Overall average **6.83** indicates small, single-purpose methods. Highest package average is `brewery.inventory` due to reservation/rollback and capacity management—still linear and cohesive.
- **Design Controls:** Method length kept ≈≤10 lines; minimal branching; array-backed scans to avoid complex traversals.

### DIT — Depth of Inheritance Tree
- **Finding:** Overall average **1.2** reflects **shallow hierarchies**. Only `brewery.plant` and `brewery.services` introduce depth via base abstractions (`Vat`, `Sensor`) with thin children.
- **Benefit:** Reduced inherited surface area → simpler reasoning and testing.

### NOC — Number of Children
- **Finding:** Overall average **0.2**; children are concentrated where type taxonomies are natural (`Vat` subclasses; sensor subclasses).
- **Approach:** Keep base classes minimal and stable; extend via thin leaf classes to preserve WMC.

### CBO — Coupling Between Objects
- **Finding:** Overall average **2.7**; coupling is purposefully centralized in façades (`BrewerySystem`) and registries.
- **Mitigation:** Constructor injection, narrow public APIs, and array-backed repositories confine dependencies.

### RFC — Response For a Class
- **Finding:** Overall average **5.53**; interfaces remain compact. `BrewerySystem` and `Inventory` have higher RFC by necessity, but no method explosions.
- **Practice:** Clear method boundaries and single responsibilities keep RFC bounded.

---

## 4) Constraints Compliance & Design Notes

- **No global mutable state**; all dependencies injected.
- **No external containers** in core stores (arrays used in `Inventory`, `RecipeLibrary`, `PlantRegistry`); a justified, localized `List/Map` in `Recipe` for authoring convenience.
- **I/O isolated** to `Console`; domain logic remains pure.
- **All-or-nothing reservations** with rollback in `createBatchByBottles` ensure consistency without heavy transactions.

---

## 5) Risks & Improvements

- **Façade coupling:** Inevitable in orchestration; kept manageable via small methods and clear boundaries.
- **Recipe collections:** Could be refactored to arrays for strictest constraint adherence (trade-off: ergonomics).
- **Production states:** Additional explicit state-transition helpers can be added while keeping WMC stable.

---

## 6) Verdict

The codebase demonstrates **low method complexity**, **shallow inheritance**, **bounded coupling**, **compact responses**, and **high cohesion** across packages.  
It satisfies the assignment’s functional scenarios and adheres closely to the imposed constraints, with deliberate, limited exceptions where they improve clarity without harming complexity.

