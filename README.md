# ClickCounter
This class listens for clicks, counts them and sends you the result trough a simple interface

## Usage Example:

```
ClickCounter counter = new ClickCounter();


view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        counter.addClick();
    }
});

counter.setClickCountListener(new ClickCounter.ClickCountListener() {
    @Override
    public void onClickingCompleted(int clickCount) {
        rewardUserWithClicks(clickCount); // Thats All!!😃
    }
});
```


## How to import this library:

Just copy and paste the ClickCounter.java class into your project classes. Enjoy
