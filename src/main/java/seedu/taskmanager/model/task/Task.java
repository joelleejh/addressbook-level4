package seedu.taskmanager.model.task;

import java.util.Objects;

import seedu.taskmanager.commons.util.CollectionUtil;
//import seedu.taskmanager.model.category.UniqueCategoryList;

/**
 * Represents a Task in the address book. Guarantees: details are present and
 * not null, field values are validated.
 */
public class Task implements ReadOnlyTask {

    private TaskName taskName;
    private StartDate startDate;
    private StartTime startTime;
    private EndDate endDate;
    private EndTime endTime;
    private boolean isMarkedAsComplete;
    // private UniqueCategoryList categories;

    /**
     * Every field must be present and not null.
     */
    public Task(TaskName taskName, StartDate startDate, StartTime startTime, EndDate endDate,
            EndTime endTime /* ,UniqueCategoryList categories */) {
        assert !CollectionUtil.isAnyNull(taskName, startDate, startTime,
                endTime/* , categories */);
        this.taskName = taskName;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.isMarkedAsComplete = false;
        // this.categories = new UniqueCategoryList(categories); // protect
        // internal tags from changes in the arg list
    }

    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this(source.getTaskName(), source.getStartDate(), source.getStartTime(), source.getEndDate(),
                source.getEndTime() /* ,source.getCategories() */);
    }

    public void setTaskName(TaskName taskName) {
        assert taskName != null;
        this.taskName = taskName;
    }

    @Override
    public TaskName getTaskName() {
        return taskName;
    }

    public void setStartDate(StartDate startDate) {
        assert startDate != null;
        this.startDate = startDate;
    }

    @Override
    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartTime(StartTime startTime) {
        assert startTime != null;
        this.startTime = startTime;
    }

    @Override
    public StartTime getStartTime() {
        return startTime;
    }

    @Override
    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate endDate) {
        assert startTime != null;
        this.endDate = endDate;
    }

    public void setEndTime(EndTime endTime) {
        assert endTime != null;
        this.endTime = endTime;
    }

    @Override
    public EndTime getEndTime() {
        return endTime;
    }

    public void setIsMarkedAsComplete(boolean isMarkedAsComplete) {
        this.isMarkedAsComplete = isMarkedAsComplete;
    }

    @Override
    public Boolean getIsMarkedAsComplete() {
        return isMarkedAsComplete;
    }

    /*
     * @Override public UniqueCategoryList getCategories() { return new
     * UniqueCategoryList(categories); }
     */
    /**
     * Replaces this task's categories with the categories in the argument
     * category list.
     *
     * public void setCategories(UniqueCategoryList replacement) {
     * categories.setCategories(replacement); }
     */
    /**
     * Updates this person with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyTask replacement) {
        assert replacement != null;

        this.setTaskName(replacement.getTaskName());
        this.setStartDate(replacement.getStartDate());
        this.setStartTime(replacement.getStartTime());
        this.setEndDate(replacement.getEndDate());
        this.setEndTime(replacement.getEndTime());
        this.setIsMarkedAsComplete(replacement.getIsMarkedAsComplete());
        // this.setCategories(replacement.getCategories());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyTask // instanceof handles nulls
                        && this.isSameStateAs((ReadOnlyTask) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing
        // your own
        return Objects.hash(taskName, startDate, startTime, endDate,
                endTime/* , categories */);
    }

    @Override
    public String toString() {
        return getAsText();
    }

}
