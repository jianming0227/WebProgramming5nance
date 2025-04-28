from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class InvestmentRequest(BaseModel):
    risk_tolerance: str
    duration_years: int
    return_expectation: float

@app.post("/recommend")
async def recommend_strategy(data: InvestmentRequest):
    # Dummy ML logic
    return {"strategy": "Balanced Portfolio", "risk": "Medium"}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)
