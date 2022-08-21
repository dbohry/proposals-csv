# proposals-csv

This project was created as some use case sample for extracting information from a CSV file and exposing it with a Rest API.

The API documentation can be found on http://localhost:8080/swagger-ui/index.html

Current available endpoints:

```
GET /proposals
GET /proposals/{id}
GET /proposals/denied
GET /proposals/count
```

### Response sample

```
{
  "id": "4db4efdd-7bfb-4a6d-8ded-acf5c2e9c7a8",
  "applicant": {
      "ethnicity": "Not Hispanic or Latino",
      "race": "White",
      "sex": "Male"
  },
  "coApplicant": {
      "ethnicity": "Not Hispanic or Latino",
      "race": "White",
      "sex": "Female"
  },
  "income": 223,
  "county": "Queens County",
  "wasProposalDenied": false
}
```

### Requirements

Java 11 or higher
