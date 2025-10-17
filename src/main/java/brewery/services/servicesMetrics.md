## **Package: brewery.services**

This package provides the brewery’s functional service layer, handling monitoring, pathfinding, scheduling, and sensor abstraction.  
It encapsulates utility behavior that supports production and plant operations without increasing their internal complexity.

| Class | WMC | DIT | NOC | CBO | RFC | **Design Comment** |
|:------|:---:|:---:|:---:|:---:|:---:|:--|
| **Sensor** | 1 | 1 | 2 | 0 | 1 | Abstract base class defining a unified interface for sensors; foundation for `Thermometer` and `Hydrometer`. |
| **Thermometer** | 2 | 2 | 0 | 0 | 2 | Concrete temperature sensor; minimal mock logic; high cohesion. |
| **Hydrometer** | 2 | 2 | 0 | 0 | 2 | Gravity measurement sensor; small, cohesive implementation. |
| **MonitoringService** | 8 | 1 | 0 | 3 | 7 | Records temperature and gravity readings to `Batch`; moderate coupling to sensors and domain classes. |
| **PathFinder** | 4 | 1 | 0 | 2 | 4 | Computes shortest paths between vats; light coupling to plant structures; currently a stub. |
| **Scheduler** | 7 | 1 | 0 | 3 | 6 | Manages scheduled `TransferOrder` execution; moderate complexity due to internal queue logic. |
| **Average (Services)** | **4** | **1.3** | **0.3** | **1.3** | **3.7** | Balanced modular utilities with consistent abstraction; low coupling and strong cohesion across the service layer. |

> **Metric notes:**
> - **WMC:** Sum of attributes and statements (estimated per class).
> - **DIT:** `Sensor` subclasses have DIT = 2; others = 1.
> - **NOC:** `Sensor` has 2 children; others have none.
> - **CBO:** Coupling arises mostly from interaction with `Batch`, `TransferOrder`, and plant components.
> - **RFC:** Reflects exposed public methods and direct external calls (e.g., recording readings, scheduling tasks).

### **Interpretation**
- **Low WMC:** Most classes perform single, self-contained tasks with minimal code volume.
- **DIT/NOC structure:** Simple inheritance hierarchy under `Sensor` improves extensibility and consistency for hardware abstraction.
- **Moderate CBO in `MonitoringService`/`Scheduler`:** Expected for coordination components; still within acceptable design bounds.
- **Low RFC overall:** Indicates clean and predictable interfaces.
- **Overall:** The service layer demonstrates **clear separation of concerns**, low complexity, and consistent abstraction boundaries, enabling easy expansion (e.g., adding new sensor types or schedulers) without system-wide changes.
