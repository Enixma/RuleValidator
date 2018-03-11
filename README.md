# RuleValidator-Android

## Usage

**RuleValidator** can be initialized 2 ways . 

1. Rule or Set of Rules . 

```java

// Ex.1 init with rule / set of rules 
RuleValidator emailValidator = new RuleValidator(new StringEmailRule("input is not in email format"));

RuleValidator passwordValidator = new RuleValidator(new RuleSet()
                                .addRule(new StringMinLengthRule(6, "at least 6 characters"))              
                                .addRule(new StringMaxLengthRule(10, "cannot exceed 10 characters")));

```

2. Value ( to be validated ) and ( Rule or Set of Rules ) .      
Result is ready upon initialization . 

```java

// Ex.2 init with (rule or set of rules) and value (to be validated)
RuleValidator emailValidator = new RuleValidator("text", new StringEmailRule("input is not in email format"));

RuleValidator passwordValidator = new RuleValidator("text", new RuleSet()            
                                .addRule(new StringMinLengthRule(6, "at least 6 characters"))      
                                .addRule(new StringMaxLengthRule(10, "cannot exceed 10 characters")));
                
```

## Validation Result when init validator with rule
Need to provide value to be validated . 

**isValid(T1 value)** . 
validate value and return boolean . 
```java
     boolean isValid = validator.isValid(value);
```

**validate(T1 value)** . 
validate value and return a list of error objects . 
```java
     List<T2> errorObjects = validator.validate(value);
```

## Validation Result when init validator with both rule and value
Able to get result right away  


**isValid()**
return result in boolean
```java
     boolean isValid = validator.isValid();
```

**getErrors()**
return list of error objects
```java
    List<T2> errorObjects = validator.getErrors();
```

## Custom Rule by creating a class . 
(See example in source code: StringMinLengthRule.java, StringMaxLengthRule.java, StringEmailRule.java) . 

Your custom rule classes can be utilized like the example below . 

**Min Length Rule**
```java
new RuleValidator("text", new StringMinLengthRule(3, "at least 3 characters"));
```
**Max Length Rule**
```java
new RuleValidator("text", new StringMaxLengthRule(5, "Exceeded 5 characters"));
```
**Email Rule**
```java
new RuleValidator("text", new StringEmailRule("Incorrect email pattern"));
```

## Custom Rule without creating a class
```java
Rule customRule = new Rule<String, String>() {   
  @Override    
  public boolean isValid(String s) {              
    return s.equals("text");    
  }    
  @Override public String getError() {        
    return "text not matched";
   }
};

new RuleValidator("text", customRule);
```


